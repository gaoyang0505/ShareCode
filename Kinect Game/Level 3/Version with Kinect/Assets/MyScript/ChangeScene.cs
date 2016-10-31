using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class ChangeScene : MonoBehaviour {

	// Use this for initialization
	private void OnGUI()
	{
	//	GUILayout.Label ("  Your Score:"+Score.SetScore.ToString());

		GUI.color = Color.red;
		GUI.skin.label.fontSize = 25;
		GUI.Label(new Rect(0,0,400,400),"  Your Score:"+Score.SetScore.ToString());

	}

	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	private void OnTriggerEnter(Collider hitCollider)
	{	
		
		//Judge if the Person Touch the Wall,if not, Judge if all the point has been touched
		//Tag the wall with wall
		if( "Change" == hitCollider.gameObject.name && Score.SetScore>0)
		{
			//PickUp item = hitCollider.GetComponent<PickUp>();
			//inventory.Add( item );
			Destroy ( hitCollider.gameObject );
			Application.LoadLevel("AvatarFrontfacing");
		}
		if( "Monachos" == hitCollider.gameObject.name )
		{
			//PickUp item = hitCollider.GetComponent<PickUp>();
			//inventory.Add( item );
			Destroy ( hitCollider.gameObject );
			Score.SetScore=Score.SetScore+10;
		}
		if( "Monachos_1" == hitCollider.gameObject.name )
		{
			//PickUp item = hitCollider.GetComponent<PickUp>();
			//inventory.Add( item );
			Destroy ( hitCollider.gameObject );
			Score.SetScore=Score.SetScore+10;
		}

		if( "Monachos_2" == hitCollider.gameObject.name )
		{
			//PickUp item = hitCollider.GetComponent<PickUp>();
			//inventory.Add( item );
			Score.SetScore=Score.SetScore-10;
		}
	}
}
