#if !defined(AFX_LOGIN_H__3C7C4BC3_D67A_4EA0_A18A_E8099F899A10__INCLUDED_)
#define AFX_LOGIN_H__3C7C4BC3_D67A_4EA0_A18A_E8099F899A10__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Login.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CLogin dialog

class CLogin : public CDialog
{
// Construction
public:
	CLogin(CWnd* pParent = NULL);   // standard constructor

	CDaoDatabase TVXQ;
	HACCEL hAccTable;

// Dialog Data
	//{{AFX_DATA(CLogin)
	enum { IDD = IDD_DIALOG2 };
	CString	m_strLogPassword;
	CString	m_strLogName;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CLogin)
	public:
	virtual BOOL PreTranslateMessage(MSG* pMsg);
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CLogin)
	afx_msg void OnButton1();
	afx_msg void OnButton2();
	virtual BOOL OnInitDialog();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LOGIN_H__3C7C4BC3_D67A_4EA0_A18A_E8099F899A10__INCLUDED_)
