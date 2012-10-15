<?php
class FoodController extends AppController {

    public function view($dininghall, $time) {
    $var1 = $this->Food->find('first', array(
        'conditions' => array('Food.DiningHall' => $dininghall, 'Food.Time' => $time)
        
    ));
    $this->set('foods', $var1);
    }
}
?>
