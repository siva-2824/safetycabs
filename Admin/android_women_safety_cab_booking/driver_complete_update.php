<?php
include("dbconnect.php");
extract($_POST);
 
$id=$_REQUEST['id'];
$driver=$_REQUEST['driver'];
$amount=$_REQUEST['amount'];
$a1=$_REQUEST['l1'];
$a2=$_REQUEST['l2'];


 

$qrys=("update booking_details set status='2' where id='$id'");
if ($conn->query($qrys) === TRUE) 
{
echo "success";
}
else
{
echo "failed";
}	
?>