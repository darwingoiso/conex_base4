<?php
if(isset($_REQUEST["nombres"]))&&isset($_REQUEST["correo"])
{
	$nombres=$_REQUEST["nombre"];
	$correo=$_REQUEST["correo"];

	$conexion=mysqli_connect("localhost","clubdelc_android","123456","clubdelc_prueba");

	$cadena="insert into alumnos('nombres','correo') values('".$nombres."','".$correo."')";

	$respuesta=mysqli_query=($conexion,$cadena);
	var_dump($respuesta);

}
?>