// Cassiopeia_313751158.h : main header file for the CASSIOPEIA_313751158 application
//

#if !defined(AFX_CASSIOPEIA_313751158_H__18CDDFC1_566C_4ECE_9D2D_371231632B72__INCLUDED_)
#define AFX_CASSIOPEIA_313751158_H__18CDDFC1_566C_4ECE_9D2D_371231632B72__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158App:
// See Cassiopeia_313751158.cpp for the implementation of this class
//

class CCassiopeia_313751158App : public CWinApp
{
public:
	CCassiopeia_313751158App();


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCassiopeia_313751158App)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CCassiopeia_313751158App)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CASSIOPEIA_313751158_H__18CDDFC1_566C_4ECE_9D2D_371231632B72__INCLUDED_)
