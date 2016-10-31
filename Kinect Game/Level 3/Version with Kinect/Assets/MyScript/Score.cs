using UnityEngine;
using System.Collections;

public class Score : MonoBehaviour {
	public static Score ScoreNum;
	public static bool DestroyOb=false;
	public static int QuestionNum=1;

	public AudioClip[] Clip;

	public static bool ControlWallOne=false;
	public static bool ControlWallTwo=false;
	public static bool ControlWallThree=false;
	public static bool ControlWallFour=false;
	public static bool ControlWallFive=false;
	public static bool ControlWallSix=false;
	public static bool ControlWallSeven=false;
	public static bool ControlWallEight=false;
	public static bool ControlWallNine=false;
	public static bool ControlWallTen=false;



	public string QuestionText="第一题";
	public static int SetScore=0;
	public static int HeadS;
	public static int LeftArmS;
	public static int RightArmS;
	public static int LeftHandS;
	public static int RightHandS;
	public static int LeftLegS;
	public static int RightLegS;
	public static int Total;

	public Texture2D imageDigit11;
	public Texture2D imageDigit21;
	public Texture2D imageDigit31;
	public Texture2D imageDigit41;
	public Texture2D imageDigit51;
	public Texture2D imageDigit61;
	public Texture2D imageDigit71;
	public Texture2D imageDigit81;
	public Texture2D imageDigit91;
	public Texture2D imageDigit101;
	public Texture2D imageDigit201;

	public static int QuestionNo=0;
	public int EndTager;

	private void OnGUI()
	{
		GUI.skin.label.fontSize = 25;
		GUI.Label (new Rect (Screen.width-230, -30, 300,210 ), CountdownTimerImage ());
		GUI.color = Color.red;
		GUI.Label(new Rect(0,0,400,400),"  Your Score:"+SetScore.ToString());
		GUI.Label (new Rect (Screen.width-330, 0, 100, 1000), QuestionText);
	}

	Texture2D CountdownTimerImage(){
		switch( QuestionNo ){
		case 10:
			return imageDigit101;
		case 6:
			return imageDigit61;
		case 7:
			return imageDigit71;
		case 8:
			return imageDigit81;
		case 9:
			return imageDigit91;
		case 5:
			return imageDigit51;
		case 4:
			return imageDigit41;
		case 3:
			return imageDigit31;
		case 2:
			return imageDigit21;
		case 1:
			return imageDigit11;
		default:
			return imageDigit201;
		}
	}

	void Awake()
	{
		ScoreNum = this;
	}

	// Use this for initialization
	void Start () {

	}

	public void GetHead(int HeadGet)
	{
		HeadS = HeadGet;
	}

	// Update is called once per frame
	void Update () 
	{
		if (MoveAutomTen.GotoEnd == 1) 
		{
			EndTager++;
		}
		if (QuestionNum == 11 && EndTager>3*24)
			Application.LoadLevel ("EndScene");

		if (SetScore >= 0) 
		{

			switch (QuestionNum) 
			{
			case 1:
				QuestionText = "白鹤亮翅";
				ControlWallOne = true;
				break;
			case 2:
				QuestionText = "掩耳盗铃";
				ControlWallTwo = true;
				break;
			case 3:
				QuestionText = "顶天立地";
				ControlWallThree = true;
				break;
			case 4:
				QuestionText = "四平八稳";
				ControlWallFour = true;
				break;
			case 5:
				QuestionText = "侧耳倾听";
				ControlWallFive = true;
				break;
			case 6:
				QuestionText = "雷打不动";
				ControlWallSix = true;
				break;
			case 7:
				QuestionText="十全十美";
				ControlWallSeven=true;
				break;
			case 8:
				QuestionText="半壁江山";
				ControlWallEight=true;
				break;
			case 9:
				QuestionText="捶胸顿足";
				ControlWallNine=true;
				break;
			case 10:
				QuestionText="拔苗助长";
				ControlWallTen=true;
				break;

			}
			if (DestroyOb == true) {
				DestroyOb = false;
				Total = HeadS + LeftArmS + LeftHandS + RightHandS + RightHandS + LeftLegS + RightLegS;
				print (HeadS.ToString ());
				print (RightLegS.ToString ());
				print (RightHandS.ToString ());
				print (RightArmS.ToString ());
				print (LeftArmS.ToString ());
				print (LeftHandS.ToString ());
				print (LeftLegS.ToString ());
				print (Total.ToString ());
				if (Total == 7) {
					SetScore++;
					AudioSource.PlayClipAtPoint (Clip [0], transform.position);
				} else {
					SetScore--;
					AudioSource.PlayClipAtPoint (Clip [1], transform.position);
				}
				QuestionNo++;
				HeadS = 0;
				LeftArmS = 0;
				LeftHandS = 0;
				RightHandS = 0;
				RightHandS = 0;
				LeftLegS = 0;
				RightLegS = 0;
				Total = 0;
			}
		}
		else
			Application.LoadLevel ("GoAround");
	}
}
