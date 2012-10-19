<?php 
$this->layout = 'ajax';

if(isset($_GET['json'])) {
echo "[";
$first = true;
foreach ($foods as $food) {
	if($first) {
		$first = false;
	}
	else {
		echo ",";
	}
	echo json_encode($food['Food']);
			
}
echo "]";
}
else if(isset($_GET['xml'])) { ?>
<foods> <?php
 foreach ($foods as $food): ?>
 <meal> <?php echo $food['Course']['Mnemonic']; ?> </meal> <calories> <?php echo $food['Course']['Number']; ?> </calories> 
<?php endforeach; 
unset($food); ?>
</foods> <?php
}
else {
foreach ($foods as $food): ?>
 <?php echo $food['meal']; ?>, <?php echo $food['calories']; ?>
<?php endforeach; 
unset($food);
}
?>


