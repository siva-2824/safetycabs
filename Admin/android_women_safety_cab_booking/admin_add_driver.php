<?php
include("dbconnect.php");
extract($_POST);
 
$name=$_REQUEST['name'];
$cont=$_REQUEST['contact'];
$email=$_REQUEST['email'];
$address=$_REQUEST['address'];
$license_no=$_REQUEST['license_no'];
 
$vehicle_name=$_REQUEST['vehicle_name'];
$vehicle_no=$_REQUEST['vehicle_no'];
$no_of_seat=$_REQUEST['no_of_seat'];
$amount=$_REQUEST['amount'];
$password=$_REQUEST['password'];
 
 

$sql = "SELECT id FROM driver_details order by id ASC";

 $sid=0;
  $result = $conn->query($sql);
  while($row = $result->fetch_assoc()) 
  {
       $sid=$row['id'];
  }
    $sid=$sid+1;



$qrys=("insert into driver_details values('$sid','$name','$cont','$email','$address','$license_no','$vehicle_name','$vehicle_no','$no_of_seat','$amount','$password','0','0')");
if ($conn->query($qrys) === TRUE) 
{
echo "success";
}
else
{
echo "failed";
}	
?>