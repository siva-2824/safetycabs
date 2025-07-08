<?php
extract($_POST);
include("dbconnect.php");
$event=$_REQUEST['pword'];
//$staff=$_REQUEST['pword'];
//$pass=$_REQUEST['pass'];
//$time=$_REQUEST['time'];
$qry=("select * from location_details where location='$event'");
 
$result1 = $conn->query($qry);

while($res = $result1->fetch_assoc())
		  {
		 echo $driver_name=$res["latitude"].'#'.$res["longitude"];
		  }
?>
 