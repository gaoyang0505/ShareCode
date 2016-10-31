using UnityEngine;
using System.Collections;

public class ShowVe : MonoBehaviour {

	public MovieTexture moveTexture;
	public int M=0;
	// Use this for initialization
	void Start () {
		gameObject.renderer.enabled = false;
		renderer.material.mainTexture = moveTexture;
		moveTexture.loop = true;
		moveTexture.Play ();
	
	}

	// Update is called once per frame
	void Update () {
		M++;
//		moveTexture.Play ();
		if (M>48*2)
			gameObject.renderer.enabled = true;
	
	}
}
