using UnityEngine;
using System.Collections;

public class BoxOpen : MonoBehaviour {
	public int SwitchBox=0;


	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {

		if (SwitchBox > 48 && SwitchBox< 96)
		{
			gameObject.transform.Rotate(Vector3.right*Time.deltaTime*-100);
		}

		SwitchBox++;
		
		
		
	
	}
}
