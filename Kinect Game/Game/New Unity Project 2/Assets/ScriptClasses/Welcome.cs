// file: GeneralInventory.cs
using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Welcome : MonoBehaviour 
{

	public string LevelName="level_1";
	


	private void OnTriggerEnter(Collider hitCollider)
	{	

		if( "next" == hitCollider.tag )
		{
			//guli_01.Play;
			Application.LoadLevel(LevelName);

			
		}

			
				

		//&&(IsChecked=false)
		//Debug.Log(check);
	}



}
