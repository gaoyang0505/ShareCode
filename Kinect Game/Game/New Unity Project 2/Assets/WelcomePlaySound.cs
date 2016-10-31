using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class  WelcomePlaySound : MonoBehaviour 
{
	public AudioClip[] clip;
	
	private void OnTriggerEnter(Collider hitCollider)
	{	

		
		if( "sound" == hitCollider.name )
		{

			AudioSource.PlayClipAtPoint(clip[0],transform.position);
			
		}

		
		

	}
	
	
	
}
