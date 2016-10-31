#pragma strict
var speed:float=0.05;

function Start () {

}

function Update () {
if(transform.position.x<9&&transform.position.x>-9)
{speed=speed;}
else
{speed=-speed;}

transform.position.x = transform.position.x + speed;



}