#if !defined(AFX_TAB_H__2771D70C_C2E1_47F5_9CD7_7808632086C1__INCLUDED_)
#define AFX_TAB_H__2771D70C_C2E1_47F5_9CD7_7808632086C1__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Tab.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CTab form view

#ifndef __AFXEXT_H__
#include <afxext.h>
#endif

#include "Login.h"
#include "Help.h"
#include "Register.h"

class CTab : public CFormView
{
protected:
	DECLARE_DYNCREATE(CTab)

// Form Data
public:
	//{{AFX_DATA(CTab)
	enum { IDD = IDD_FORMVIEW_Tab };
	CTabCtrl	m_ctrlTab;
	//}}AFX_DATA

// Attributes
public:

// Operations
public:
	CTab();           // protected constructor used by dynamic creation

	CHelp m_TabHelp;
	CLogin m_TabLogin;
	CRegister m_TabR;

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTab)
	public:
	virtual void OnInitialUpdate();
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	virtual ~CTab();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

	// Generated message map functions
	//{{AFX_MSG(CTab)
	afx_msg void OnSelchangeTab1(NMHDR* pNMHDR, LRESULT* pResult);
	afx_msg void OnSTATICHello();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TAB_H__2771D70C_C2E1_47F5_9CD7_7808632086C1__INCLUDED_)
