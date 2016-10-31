#if !defined(AFX_MENUALL_H__A2FD7D4B_6E5F_4EF6_BC49_E3F9AA1DD55A__INCLUDED_)
#define AFX_MENUALL_H__A2FD7D4B_6E5F_4EF6_BC49_E3F9AA1DD55A__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// MenuAll.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CMenuAll dialog

class CMenuAll : public CDialog
{
// Construction
public:
	CMenuAll(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(CMenuAll)
	enum { IDD = IDD_DIALOG5 };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMenuAll)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CMenuAll)
	virtual void OnOK();
	afx_msg void OnButton1();
	afx_msg void OnButton2();
	afx_msg void OnButton3();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_MENUALL_H__A2FD7D4B_6E5F_4EF6_BC49_E3F9AA1DD55A__INCLUDED_)
