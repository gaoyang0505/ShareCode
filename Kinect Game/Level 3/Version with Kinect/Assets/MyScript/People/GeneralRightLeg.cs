using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class GeneralRightLeg : MonoBehaviour {
	const int ICON_HEIGHT = 32;
	private List<PickUp> inventory = new List<PickUp>();
	
	private void OnGUI()
	{
		// restrict display to left of screen
		Rect r = new Rect(0,0,Screen.width/2, ICON_HEIGHT);
		GUILayout.BeginArea(r);
		GUILayout.BeginHorizontal();
		
		DisplayInventory();
		
		GUILayout.FlexibleSpace();
		GUILayout.EndHorizontal();
		GUILayout.EndArea();
	}
	
	private void DisplayInventory()
	{
		foreach (PickUp item in inventory)
		{
			GUILayout.Label( item.icon );
		}
	}
	
	private void OnTriggerEnter(Collider hitCollider)
	{	
		//Judge if the Person Touch the Wall,if not, Judge if all the point has been touched
		//Tag the wall with wall
		if( "RightLeg" == hitCollider.tag )
		{
			PickUp item = hitCollider.GetComponent<PickUp>();
			inventory.Add( item );
			Destroy ( hitCollider.gameObject );
			Score.RightLegS=1;
		}
	}

}
