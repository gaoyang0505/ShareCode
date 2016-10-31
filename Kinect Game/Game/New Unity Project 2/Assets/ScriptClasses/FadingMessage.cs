// file: FadingMessage
using UnityEngine;
using System.Collections;
public class FadingMessage : MonoBehaviour {
	//private float a=0.0f;
	public  float DURATION = 15.0f;
	private void Update() {
		if( Time.timeSinceLevelLoad > DURATION){
			Destroy(gameObject);
		}
		Color newColor = guiText.material.color;
		float proportion = (Time.timeSinceLevelLoad / DURATION);
		newColor.a = Mathf.Lerp(1, 0, proportion);
		guiText.material.color = newColor;
	}
}