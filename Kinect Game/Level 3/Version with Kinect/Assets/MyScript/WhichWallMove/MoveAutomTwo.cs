using UnityEngine;
using System.Collections;

public class MoveAutomTwo : MonoBehaviour {
	public Vector3 pos;
	public int M=1;
	public AudioClip[] ClipTwo;
	// Use this for initialization
	void Start () {
		gameObject.renderer.enabled = false;

	}
	
	// Update is called once per frame
	void Update () {

		//Control the wall's position; Wheather it should go or not?
		//gameObject.renderer.enabled = false; 仅不显示物体
		if (Score.ControlWallTwo == true) 
		{
			if (M == 1) {
				AudioSource.PlayClipAtPoint (ClipTwo [0], transform.position);
				M++;
			}
			//gameObject.SetActive (true);    //不显示，也不动
			gameObject.renderer.enabled = true;
			pos.z = transform.position.z-0.01f;
			pos.x=GetPosition.PeopleX-0.1f;
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
