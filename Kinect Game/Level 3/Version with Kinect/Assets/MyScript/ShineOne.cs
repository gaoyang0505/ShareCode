using UnityEngine;
using System.Collections;

public class ShineOne : MonoBehaviour {
	public Transform boomFire;
	// Use this for initialization
	void Start () {
		Instantiate(boomFire,this.transform.position,Quaternion.identity);
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}
}
