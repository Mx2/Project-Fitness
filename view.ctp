<?php foreach ($foods as $food):
	echo $food['meal'];
?> -- <?php 
	echo $food['calories']; ?>
<?php endforeach; ?>
<?php unset($food); ?>
