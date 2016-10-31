#if !defined(AFX_REGISTER_H__83857B69_2ED6_4AC8_ACDC_2FDF25F5BDF3__INCLUDED_)
#define AFX_REGISTER_H__83857B69_2ED6_4AC8_ACDC_2FDF25F5BDF3__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Register.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CRegister dialog

class CRegister : public CDialog
{
// Construction
public:
	CRegister(CWnd* pParent = NULL);   // standard constructor
	CDaoDatabase TVXQ;
// Dialog Data
	//{{AFX_DATA(CRegister)
	enum { IDD = IDD_DIALOG3 };
	CString	m_strRegOKPassword;
	CString	m_strRegPassword;
	CString	m_strRegName;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CRegister)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CRegister)
	afx_msg void OnButton1();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_REGISTER_H__83857B69_2ED6_4AC8_ACDC_2FDF25F5BDF3__INCLUDED_)
