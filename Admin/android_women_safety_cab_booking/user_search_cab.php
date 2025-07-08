<?php

function distance($lat1, $lon1, $lat2, $lon2, $unit) {

  $theta = $lon1 - $lon2;
  $dist = sin(deg2rad($lat1)) * sin(deg2rad($lat2)) +  cos(deg2rad($lat1)) * cos(deg2rad($lat2)) * cos(deg2rad($theta));
  $dist = acos($dist);
  $dist = rad2deg($dist);
  $miles = $dist * 60 * 1.1515;
  $unit = strtoupper($unit);

  if ($unit == "K") {
      return ($miles * 1.609344);
  } else if ($unit == "N") {
      return ($miles * 0.8684);
  } else {
      return $miles;
  }
}
include("dbconnect.php");
extract($_POST);
 
$user=$_REQUEST['name'];
$latitude=$_REQUEST['latitude'];
$longitude=$_REQUEST['longitude'];
$source=$_REQUEST['source'];
$destination=$_REQUEST['destination'];
 
 $latitude1=$_REQUEST['latitude1'];
$longitude1=$_REQUEST['longitude1'];
 $dis1=distance($latitude, $longitude,$latitude1, $longitude1, "K") ;
  $dis= round($dis1, 2);  
 $avg_duration=$dis*2;
 
$sql = "SELECT id FROM booking_details order by id ASC";

 $sid=0;
  $result = $conn->query($sql);
  while($row = $result->fetch_assoc()) 
  {
       $sid=$row['id'];
  }
    $sid=$sid+1;



$qrys=("insert into booking_details values('$sid','$user','$latitude','$longitude','$source','$destination','0','0','0','0','0','$latitude1','$longitude1','$dis','0','0','$avg_duration','-')");
if ($conn->query($qrys) === TRUE) 
{
echo $sid;
}


/////////////////////////////////////
  $sql1 = "SELECT * FROM location_details where location='$source'";

 $sid=0;
  $result1 = $conn->query($sql1);
  if($row1 = $result1->fetch_assoc()) 
  {
        
  }
  else
  {
    $sql2 = "SELECT id FROM location_details order by id ASC";

 $sid=0;
  $result22 = $conn->query($sql2);
  while($row22 = $result22->fetch_assoc()) 
  {
       $sid22=$row22['id'];
  }
    $sid22=$sid22+1;
   $qrys=("insert into location_details values('$sid22','$source','$latitude','$longitude')");
if ($conn->query($qrys) === TRUE) 
{
}

  }	
?>