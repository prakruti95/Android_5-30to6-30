<?php
  
  include('connect.php');
  
  $sql ="select * from info";
  $response= array(); 
  $r = mysqli_query($con,$sql);
  
  while($row = mysqli_fetch_array($r))
  {
    $value["id"] = $row["id"];
    $value["name"] = $row["name"];
    $value["surname"] = $row["surname"];
   
    
    
    array_push($response,$value);
  }
  
  echo json_encode($response);
  
  

?>