using UnityEngine;
using System.Collections;

public class SceneOneMove : MonoBehaviour {
	public Vector3 pos;
	public static float LeftArmPX;
	public static float LeftArmPZ;
	public static float LeftHandPX;
	public static float LeftHandPZ;

	public static float RightArmPX;
	public static float RightArmPZ;
	public static float RightHandPX;
	public static float RightHandPZ;


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
		if (LeftHandPX - LeftArmPX > 0.3) 
		{
			pos.z = transform.position.z; // Go YOU
			pos.x=transform.position.x-0.1f;
			pos.y=transform.position.y;
		}

		if (RightArmPX-RightHandPX   > 0.3) 
		{
			pos.z = transform.position.z; // Go ZUO
			pos.x=transform.position.x+0.1f;
			pos.y=transform.position.y;
		}

		if (RightHandPY > HeadPY) 
		{
			pos.z = transform.position.z-0.1f; 
			pos.x=transform.position.x;
			pos.y=transform.position.y;
		}

		if (LeftHandPY > HeadPY) 
		{
			pos.z = transform.position.z+0.1f; 
			pos.x=transform.position.x;
			pos.y=transform.position.y;
		}
			


		transform.position = pos; 
	
	}
}
