using UnityEngine;
using System.Collections;

public class MoveAutomTen : MonoBehaviour {
	public Vector3 pos;
	public static int GotoEnd=0;
	public AudioClip[] ClipTen;
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
		if (Score.ControlWallTen == true) 
		{
			GotoEnd++;
			if(M==1)
			{
				AudioSource.PlayClipAtPoint (ClipTen [0], transform.position);
				M++;
			}
			gameObject.renderer.enabled = true;
			pos.z = transform.position.z-0.04f;
			//pos.x = transform.position.x;
			//pos.y = transform.position.y;
			pos.x=GetPosition.PeopleX-0.15f;
			pos.y=GetPosition.PeopleY+1.4f;
			transform.position = pos; 
			
			if (GetPosition.PeopleZ - pos.z > 0.3) 
			{
				GotoEnd=1;
				Destroy (gameObject);
				Score.DestroyOb=true;
				Score.QuestionNum++;
			}
		}				
	}
}
