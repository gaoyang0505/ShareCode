using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Shine : MonoBehaviour {

	public Transform boomFire;
	public int Tar=1;

	void Start()
	{
		Instantiate(boomFire,this.transform.position,this.transform.rotation);
		//boomFire.particleSystem.Emit (5);
	}

	void Update()
	{
		Tar++;
		if(Tar%96==0)
			Instantiate(boomFire,this.transform.position,this.transform.rotation);
	}



	private void OnTriggerEnter(Collider hitCollider)
	{	


	}

}