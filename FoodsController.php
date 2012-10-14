<?php
class FoodController extends AppController {

    public function view($dininghall, $time) {
        $this->set('foods', $this->Food->find('all', array('conditions' => array('Food.dining_hall' => $dininghall, 'Food.time' => $time))));
    }
}
?>
