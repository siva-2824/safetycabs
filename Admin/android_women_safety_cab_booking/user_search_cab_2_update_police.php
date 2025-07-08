<?php
include("dbconnect.php");
extract($_POST);
 
$id=$_REQUEST['id'];
$police=$_REQUEST['police'];
 


 date_default_timezone_set("Asia/Calcutta"); 
$time = date('H:i:s');

$qrys=("update booking_details set police='$police'  where id='$id'");
if ($conn->query($qrys) === TRUE) 
{
echo "success";
}
else
{
echo "failed";
}	
?>