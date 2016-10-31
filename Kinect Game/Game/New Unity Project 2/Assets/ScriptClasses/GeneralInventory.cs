// file: GeneralInventory.cs
using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class GeneralInventory : MonoBehaviour 
{
	const int ICON_HEIGHT = 130;
	private List<PickUp> inventory = new List<PickUp>();
	//public AudioClip[] clips;
	private float secondsLeft=5.0f;

	private int score=0;
	private int num1=-1;
	private int num2=-1;
	private int num3=-1;
	private int num4=-1;
	private int num5=-1;
	private int num6=-1;
	private int num7=-1;
	private int num8=-1;
	private int num9=-1;
	private int num10=-1;
	//string question="";

//	public Audio audio1;
//	public GameObject boomFire;


	
	private void OnGUI()
	{
		GUI.skin.label.fontSize = 40;
	//	GUI.Label(Rect(10,Screen.height-100,500,100),question);

		// restrict display to left of screen
		Rect r = new Rect(0,100,Screen.width, ICON_HEIGHT);
		GUILayout.BeginArea(r);
		GUILayout.BeginHorizontal();
		
		DisplayInventory();

		
		GUILayout.FlexibleSpace();
		GUILayout.EndHorizontal();
		GUILayout.EndArea();
		if(secondsLeft>=0){string s="The game will start in\t";
			string e="\ts";
		string a = s + ((int)secondsLeft).ToString ()+e;
			GUI.Label (new Rect (0, 50, 1000, 50), a);}


		GUI.skin.label.fontSize = 40;
		//GUILayout.Label("Score:"+(int)score);
		string ss = "Score:" + score.ToString ();
		GUI.Label (new Rect (0, 0, 400, 50), ss);

		//string s = "score:"+score.ToString();
		//GUI.Label (Rect (10, 10, 100, 10), s);

	}
	
	private void DisplayInventory()
	{
		foreach (PickUp item in inventory)
		{
			GUILayout.Label( item.icon );
		}


	}
	
	private void OnTriggerEnter(Collider hitCollider)
		{	
	//	Instantiate(boomFire,this.transform.position,this.transform.rotation);
		string CurrentName=Application.loadedLevelName;


		if ((CurrentName == "level_1")&&secondsLeft<=0) {
		//	question="有朋自远方来";


			int []sum=new int[] {0,0,0,0,0,0};
			int check=0;
						if ("you" == hitCollider.name) {
								PickUp item = hitCollider.GetComponent<PickUp> ();
								inventory.Add (item);
								num1 += 1;
								//sum [num1] = 1;
				if(num1==0){score+=10;}
								Destroy (hitCollider.gameObject);

						}
						if ("peng" == hitCollider.name) {
								PickUp item = hitCollider.GetComponent<PickUp> ();
								inventory.Add (item);
								num1 += 1;
								//sum [num1] = 2;
				if(num1==1){score+=10;}
								Destroy (hitCollider.gameObject);

			
						}
						if ("zi" == hitCollider.name) {
								PickUp item = hitCollider.GetComponent<PickUp> ();
								inventory.Add (item);
								num1 += 1;
								//sum [num1] = 3;
				if(num1==2){score+=10;}
								Destroy (hitCollider.gameObject);

			
						}
						if ("yuan" == hitCollider.name) {
								PickUp item = hitCollider.GetComponent<PickUp> ();
								inventory.Add (item);
								num1 += 1;
								//sum [num1] = 4;
				if(num1==3){score+=10;}
								Destroy (hitCollider.gameObject);

			
						}
						if ("fang" == hitCollider.name) {
								PickUp item = hitCollider.GetComponent<PickUp> ();
								inventory.Add (item);
								num1+= 1;
								//sum [num1] = 5;
				if(num1==4){score+=10;}
								Destroy (hitCollider.gameObject);

			
						}
						if ("lai" == hitCollider.name) {
								PickUp item = hitCollider.GetComponent<PickUp> ();
								inventory.Add (item);
								num1 += 1;
								//sum [num1] = 6;
				if(num1==5){score+=10;}
								Destroy (hitCollider.gameObject);

			}

			
						}
			//check = sum [0] * 100000 + sum [1] * 10000 + sum [2] * 1000 + sum [3] * 100 + sum [4] * 10 + sum [5];
		if (num1==5)
		{if(score== 60) 
			{Application.LoadLevel("level_2");}
			else{Application.LoadLevel("level_1");
//				audio1.Play;
			}
		}
		
		if (CurrentName == "level_2"&&secondsLeft<=0) {

			int []sum=new int[] {0,0,0,0};
			int check=0;

			if ("wu" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num2 += 1;
				if(num2==0){score+=10;}
				//sum [num2] = 1;

				Destroy (hitCollider.gameObject);
				
				
			}
			if ("ri" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num2 += 1;
				if(num2==1){score+=10;}
				//sum [num2] = 2;
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("san" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num2 += 1;
				if(num2==2){score+=10;}
				//sum [num2] = 3;
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("xing" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num2 += 1;
				if(num2==3){score+=10;}
				//sum [num2] = 4;
				Destroy (hitCollider.gameObject);

				
				
			}

		
		//check =sum [0] * 1000 + sum [1] * 100 + sum [2] * 10 + sum [3];
			if (num2==3)
			{if(score== 40) 
				{Application.LoadLevel("level_3");}
			else{Application.LoadLevel("level_2");}
			}

		}
		if ((CurrentName == "level_3")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0};
			int check=0;
			if ("wen" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num3 += 1;
				//sum [num1] = 1;
				if(num3==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("gu" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num3 += 1;
				//sum [num1] = 2;
				if(num3==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("er" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num3 += 1;
				//sum [num1] = 3;
				if(num3==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("zhi" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num3 += 1;
				//sum [num1] = 4;
				if(num3==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("xin" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num3 += 1;
				//sum [num1] = 6;
				if(num3==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			
			
		}
		//check = sum [0] * 100000 + sum [1] * 10000 + sum [2] * 1000 + sum [3] * 100 + sum [4] * 10 + sum [5];
		if (num3==4)
		{if(score== 50) 
			{Application.LoadLevel("level_4");}
			else{Application.LoadLevel("level_3");
				//				audio1.Play;
			}
		}
		if ((CurrentName == "level_4")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0,0};
			int check=0;
			if ("xue" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num4 += 1;
				//sum [num1] = 1;
				if(num4==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("er" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num4 += 1;
				//sum [num1] = 2;
				if(num4==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("bu" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num4 += 1;
				//sum [num1] = 3;
				if(num4==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("si" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num4 += 1;
				//sum [num1] = 4;
				if(num4==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("ze" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num4+= 1;
				//sum [num1] = 5;
				if(num4==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("wang" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num4 += 1;
				//sum [num1] = 6;
				if(num4==5){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			
			
		}
		//check = sum [0] * 100000 + sum [1] * 10000 + sum [2] * 1000 + sum [3] * 100 + sum [4] * 10 + sum [5];
		if (num4==5)
		{if(score== 60) 
			{Application.LoadLevel("level_5");}
			else{Application.LoadLevel("level_4");
				//				audio1.Play;
			}
		}

		if ((CurrentName == "level_5")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0};
			int check=0;
			if ("zhi1" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num5 += 1;
				//sum [num1] = 1;
				if(num5==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("zhi2" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num5 += 1;
				//sum [num1] = 2;
				if(num5==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("wei" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num5 += 1;
				//sum [num1] = 3;
				if(num5==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("zhi3" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num5 += 1;
				//sum [num1] = 4;
				if(num5==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("zhi4" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num5 += 1;
				//sum [num1] = 6;
				if(num5==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("BOOM" == hitCollider.name) {
				Destroy (hitCollider.gameObject);
				Application.LoadLevel("level_5");
				
			}
			
			
		}
		//check = sum [0] * 100000 + sum [1] * 10000 + sum [2] * 1000 + sum [3] * 100 + sum [4] * 10 + sum [5];
		if (num5==4)
		{if(score== 50) 
			{Application.LoadLevel("level_6");}
			else{Application.LoadLevel("level_5");
				//				audio1.Play;
			}
		}
		
		if ((CurrentName == "level_6")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0};
			int check=0;
			if ("jian" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num6 += 1;
				//sum [num1] = 1;
				if(num6==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("xian" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num6 += 1;
				//sum [num1] = 2;
				if(num6==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("si" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num6 += 1;
				//sum [num1] = 3;
				if(num6==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("qi" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num6 += 1;
				//sum [num1] = 4;
				if(num6==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}

			if ("BOOM" == hitCollider.name) {
				Destroy (hitCollider.gameObject);
				Application.LoadLevel("level_6");
				
			}
			
			
		}

		if (num6==3)
		{if(score== 40) 
			{Application.LoadLevel("level_7");}
			else{Application.LoadLevel("level_6");

			}
		}
		if ((CurrentName == "level_7")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0,0,0};
			int check=0;
			if ("san" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 1;
				if(num7==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("ren" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 2;
				if(num7==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("xing" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 3;
				if(num7==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("bi" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 4;
				if(num7==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("you" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 4;
				if(num7==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("wo" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 4;
				if(num7==5){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("shi" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num7 += 1;
				//sum [num1] = 4;
				if(num7==6){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			
			if ("BOOM" == hitCollider.name) {
				Destroy (hitCollider.gameObject);
				Application.LoadLevel("level_7");
				
			}
			
			
		}
		
		if (num7==6)
		{if(score==70) 
			{Application.LoadLevel("level_8");}
			else{Application.LoadLevel("level_7");
				
			}
		}
		if ((CurrentName == "level_8")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0};
			int check=0;
			if ("ren" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num8 += 1;
				//sum [num1] = 1;
				if(num8==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("zhong" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num8 += 1;
				//sum [num1] = 2;
				if(num8==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("er" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num8 += 1;
				//sum [num1] = 3;
				if(num8==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("dao" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num8 += 1;
				//sum [num1] = 4;
				if(num8==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("yuan" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num8 += 1;
				//sum [num1] = 4;
				if(num8==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}

			if ("BOOM" == hitCollider.name) {
				Destroy (hitCollider.gameObject);
				Application.LoadLevel("level_8");
				
			}
			
			
		}
		
		if (num8==4)
		{if(score==50) 
			{Application.LoadLevel("level_9");}
			else{Application.LoadLevel("level_8");
				
			}
		}
		if ((CurrentName == "level_9")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0};
			int check=0;
			if ("song" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num9 += 1;
				//sum [num1] = 1;
				if(num9==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("bai" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num9 += 1;
				//sum [num1] = 2;
				if(num9==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("zhi" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num9 += 1;
				//sum [num1] = 3;
				if(num9==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("hou" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num9 += 1;
				//sum [num1] = 4;
				if(num9==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("diao" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num9 += 1;
				//sum [num1] = 4;
				if(num9==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			
			if ("BOOM" == hitCollider.name) {
				Destroy (hitCollider.gameObject);
				Application.LoadLevel("level_9");
				
			}
			
			
		}
		
		if (num9==4)
		{if(score==50) 
			{Application.LoadLevel("level_10");}
			else{Application.LoadLevel("level_9");
				
			}
		}
		if ((CurrentName == "level_10")&&secondsLeft<=0) {
			int []sum=new int[] {0,0,0,0,0,0,0,0};
			int check=0;
			if ("ji" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10 += 1;
				//sum [num1] = 1;
				if(num10==0){score+=10;}
				Destroy (hitCollider.gameObject);
				
			}
			if ("suo" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10 += 1;
				//sum [num1] = 2;
				if(num10==1){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("bu" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10+= 1;
				//sum [num1] = 3;
				if(num10==2){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("yu" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10+= 1;
				//sum [num1] = 4;
				if(num10==3){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("wu" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10 += 1;
				//sum [num1] = 4;
				if(num10==4){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("shi" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10 += 1;
				//sum [num1] = 4;
				if(num10==5){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("yu2" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10 += 1;
				//sum [num1] = 4;
				if(num10==6){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			if ("ren" == hitCollider.name) {
				PickUp item = hitCollider.GetComponent<PickUp> ();
				inventory.Add (item);
				num10 += 1;
				//sum [num1] = 4;
				if(num10==7){score+=10;}
				Destroy (hitCollider.gameObject);
				
				
			}
			
			if ("BOOM" == hitCollider.name) {
				Destroy (hitCollider.gameObject);
				Application.LoadLevel("level_10");
				
			}
			
			
		}
		
		if (num10==7)
		{if(score==80) 
			{Application.LoadLevel("scene");}
			else{Application.LoadLevel("level_10");
				
			}
		}





}
	private void Update(){
		secondsLeft -= Time.deltaTime;
	}}