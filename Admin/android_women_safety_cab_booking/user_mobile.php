<?php
extract($_POST);
include("dbconnect.php");
$event=$_REQUEST['uname'];
$staff=$_REQUEST['pword'];
//$pass=$_REQUEST['pass'];
//$time=$_REQUEST['time'];
$qry=("select * from user_details where email='$event' && password='$staff'");
 
$result1 = $conn->query($qry);

while($res = $result1->fetch_assoc())
		  {
		 echo $driver_name=$res["parent_contact"];
		  }
?>
 