<?php
include("dbconnect.php");
extract($_POST);
 
$id=$_REQUEST['id'];
$driver=$_REQUEST['driver'];
$amount=$_REQUEST['amount'];
$a1=$_REQUEST['l1'];
$a2=$_REQUEST['l2'];


 date_default_timezone_set("Asia/Calcutta"); 
$time = date('H:i:s');

$qrys=("update booking_details set driver_name='$driver',amount='$amount',status='1',driver_l1='$a1',driver_l2='$a2',start_time='$time' where id='$id'");
if ($conn->query($qrys) === TRUE) 
{
echo "success";
}
else
{
echo "failed";
}	
?>