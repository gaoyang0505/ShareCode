#pragma strict
var creationTime=Time.time;
function Start () {
creationTime=Time.time;

}

function Update () {
if(Time.time>(creationTime+1)){
Destroy(gameObject);
}

}