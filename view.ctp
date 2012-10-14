<?php 
$this->layout = 'ajax';

foreach ($foods as $food):
	echo $food['meal'];
?> -- <?php 
	echo $food['calories']; 
?> calories
<?php endforeach; ?>
<?php unset($food); ?>
