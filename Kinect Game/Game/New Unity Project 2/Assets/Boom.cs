using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Boom : MonoBehaviour {

	public GameObject boomFire;


private void OnTriggerEnter(Collider hitCollider)
{	
		Instantiate(boomFire,this.transform.position,this.transform.rotation);

}

}