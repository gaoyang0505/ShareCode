using UnityEngine;
using System.Collections;

public class SceneOneMove : MonoBehaviour {
	public Vector3 pos;
	public static float LeftArmP;
	public static float LeftHandP;

	public static float RightArmP;
	public static float RightHandP;

	public static float HeadPY;
	public static float RightHandPY;
	public static float LeftHandPY;

	// Use this for initialization
	void Start () {
		pos.x = transform.position.x;
		pos.y = transform.position.y;
		pos.z = transform.position.z;
	
	}
	
	// Update is called once per frame
	void Update () {
		if (LeftHandP - LeftArmP > 0.25) 
		{
			pos.z = transform.position.z-0.1f; // Go right
			pos.x=transform.position.x;
			pos.y=transform.position.y;
		}

		if (RightArmP - RightHandP > 0.17) 
		{
			pos.z = transform.position.z+0.1f; // Go left
			pos.x=transform.position.x;
			pos.y=transform.position.y;
		}

		if (RightHandPY > HeadPY) 
		{
			pos.z = transform.position.z; // Go Ahead
			pos.x=transform.position.x+0.1f;
			pos.y=transform.position.y;
		}

		if (LeftHandPY > HeadPY) 
		{
			pos.z = transform.position.z; // Go Back
			pos.x=transform.position.x-0.1f;
			pos.y=transform.position.y;
		}
			

		//pos.z = transform.position.z-2.0f; // Go Right

		//pos.x = transform.position.x;
		//pos.y = transform.position.y;
		//pos.x=GetPosition.PeopleX+2.0f;//Go Ahead
		//pos.y=GetPosition.PeopleY+1.4f;
		transform.position = pos; 
	
	}
}
