<?php
include("dbconnect.php");
extract($_POST);
 
$id=$_REQUEST['id'];

 
 

$sql = "SELECT * FROM booking_details where id='$id' and status='1'";

 $sid=0;
  $result = $conn->query($sql);
  while($row = $result->fetch_assoc()) 
  {
      echo $sid=$row['id'];
  }
 	
?>