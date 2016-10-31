#if !defined(AFX_HELP_H__CCDD1A68_0EEF_4AE7_86C6_F6000D70AE8B__INCLUDED_)
#define AFX_HELP_H__CCDD1A68_0EEF_4AE7_86C6_F6000D70AE8B__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Help.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CHelp dialog

class CHelp : public CDialog
{
// Construction
public:
	CHelp(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(CHelp)
	enum { IDD = IDD_DIALOG4 };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CHelp)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CHelp)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_HELP_H__CCDD1A68_0EEF_4AE7_86C6_F6000D70AE8B__INCLUDED_)
