
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
  $id=$_REQUEST['id'];
  $l1=$_REQUEST['l1'];
    $l2=$_REQUEST['l2'];
 date_default_timezone_set("Asia/Calcutta"); 
$time1 = date('H:i:s');
 
$qry=("select * from booking_details where id='$id'");
$rt=$qry;
$result = array();
$result1 = $conn->query($qry);
while($res = $result1->fetch_assoc())
{
	$latitude=$res["latitude"];
	$longitude=$res["longitude"];
	$destination_latitude=$res["destination_latitude"];
	$destination_longitude=$res["destination_longitude"];
	  $distance=$res["distance"];
	// $dis=distance($latitude, $longitude,$destination_latitude, $destination_longitude, "K") ;
	  $dis1=distance($l1, $l2,$destination_latitude, $destination_longitude, "K") ;
	     $dis= round($dis1, 2)-0.2;  
	 if($dis>$distance)
	 {
	 echo "Direction Alert";
	 }
	 //echo $dis.'-'.$distance;
	 ///////////////////////////////////////////////
	 $start=$res["start_time"];	
	 $start1 = strtotime($time1);
	 $end1 = strtotime($start);
	 $elapsed = $start1 - $end1;
	 $currrent_duration=$elapsed/60;
	 $avg_duration=$res["avg_duration"];
	  if($currrent_duration>$avg_duration)
	 {
	 echo "Time Alert";
	 }

	 

 
}
?>
 
 