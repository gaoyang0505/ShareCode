#if !defined(AFX_PASSWORD_H__51703ADC_6F82_44E1_829F_5E10C476EF28__INCLUDED_)
#define AFX_PASSWORD_H__51703ADC_6F82_44E1_829F_5E10C476EF28__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// PassWord.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CPassWord dialog

class CPassWord : public CDialog
{
// Construction
public:
	CPassWord(CWnd* pParent = NULL);   // standard constructor
	CDaoDatabase TVXQ;
// Dialog Data
	//{{AFX_DATA(CPassWord)
	enum { IDD = IDD_DIALOG1 };
	CString	m_strSurePassword;
	CString	m_strNewPassword;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CPassWord)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CPassWord)
	afx_msg void OnButton1();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_PASSWORD_H__51703ADC_6F82_44E1_829F_5E10C476EF28__INCLUDED_)
