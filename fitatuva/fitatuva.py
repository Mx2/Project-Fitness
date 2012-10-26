import cgi
import datetime
import urllib
import webapp2

from google.appengine.ext import db
from google.appengine.api import users


class Diary(db.Model):
  author = db.StringProperty()
  content = db.StringProperty()
  date = db.DateTimeProperty(auto_now_add=True)


def diary_key(diary_name=None):
  return db.Key.from_path('Diary', diary_name or 'default_diary')


class MainPage(webapp2.RequestHandler):
  def get(self):
    self.response.out.write('<html><body>')
    diary_name=self.request.get('diary_name')

    entries = db.GqlQuery("SELECT * "
                            "FROM Diary "
                            "WHERE ANCESTOR IS :1 "
                            "ORDER BY date DESC LIMIT 5",
                            diary_key(diary_name))

    for entry in entries:
      if entry.author:
        self.response.out.write(
            'On <b>%s</b> you consumed:' % entry.date.ctime())
      else:
        self.response.out.write('An anonymous person wrote:')
      self.response.out.write('<blockquote>%s calories</blockquote>' %
                              cgi.escape(entry.content))

    self.response.out.write("""
        <label>Enter the number of calories you had on your last meal:</label>
          <form action="/sign" method="post">
            <div><textarea name="content" rows="1" cols="30"></textarea></div>
            <div><input type="submit" value="Submit"></div>
          </form>
        </body>
      </html>""")


class DiaryEntry(webapp2.RequestHandler):
  def post(self):
    diary_name = self.request.get('diary_name')
    entry = Diary(parent=diary_key(diary_name))

    if users.get_current_user():
      entry.author = users.get_current_user().nickname()

    entry.content = self.request.get('content')
    entry.put()
    self.redirect('/?')


app = webapp2.WSGIApplication([('/', MainPage),
                               ('/sign', DiaryEntry)],
                              debug=True)
