﻿using UnityEngine;
using System.Collections;

public class MoveAutomSix : MonoBehaviour {
	public Vector3 pos;
	public AudioClip[] ClipSix;
	public int M=1;
	// Use this for initialization
	void Start () {
		gameObject.renderer.enabled = false;
	}
	
	// Update is called once per frame
	void Update () {
		//Control the wall's position; Wheather it should go or not?
		//    //不显示，也不动
		//gameObject.renderer.enabled = false; 仅不显示物体
		if (Score.ControlWallSix == true) 
		{
			if(M==1)
			{
				AudioSource.PlayClipAtPoint (ClipSix [0], transform.position);
				M++;
			
			}
			gameObject.renderer.enabled = true;
			pos.z = transform.position.z-0.02f;
			//pos.x = transform.position.x;
			//pos.y = transform.position.y;
			pos.x=GetPosition.PeopleX-0.15f;
			pos.y=GetPosition.PeopleY+1.5f;
			transform.position = pos; 
			
			if (GetPosition.PeopleZ - pos.z > 0.3) 
			{
				Destroy (gameObject);
				Score.DestroyOb=true;
				Score.QuestionNum++;
			}
		}				
	}
}
