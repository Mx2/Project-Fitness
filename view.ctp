<?php 
$this->layout = 'ajax';

foreach ($foods as $food):
	echo $food['meal'];
	echo $food['calories']; 
endforeach;
unset($food);
?>
