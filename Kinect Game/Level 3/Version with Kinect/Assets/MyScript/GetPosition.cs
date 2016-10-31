using UnityEngine;
using System.Collections;

public class GetPosition : MonoBehaviour {
	public static float PeopleZ;
	public static float PeopleX;
	public static float PeopleY;

	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
		PeopleZ = transform.position.z;
		PeopleX = transform.position.x;
		PeopleY = transform.position.y;

	}
}
