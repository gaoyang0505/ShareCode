using UnityEngine;
using System.Collections;
public class CountdownTimer : MonoBehaviour {
	private float secondsLeft = 100f;
	private void OnGUI(){
		if( secondsLeft >90)
			GUILayout.Label("第一题：\t\t\t\t有朋自远方来\t\t\t\t"+"剩余时间:" + ((int)
			                secondsLeft-90));
		else
			GUILayout.Label("countdown has finished");
		GUI.skin.label.fontSize = 25;
	}

	private void Update(){
		secondsLeft -= Time.deltaTime;
	}
}