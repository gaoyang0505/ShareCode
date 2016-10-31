#pragma strict
var speed:float=0.05;

function Start () {

}

function Update () {
if(transform.position.z<6&&transform.position.z>-4)
{speed=speed;}
else
{speed=-speed;}

transform.position.z = transform.position.z + speed;



}