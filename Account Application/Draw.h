#if !defined(AFX_DRAW_H__7C7F0055_491F_403E_8441_213ECB5127CE__INCLUDED_)
#define AFX_DRAW_H__7C7F0055_491F_403E_8441_213ECB5127CE__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Draw.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CDraw form view

#ifndef __AFXEXT_H__
#include <afxext.h>
#endif

class CDraw : public CFormView
{
protected:

	DECLARE_DYNCREATE(CDraw)

// Form Data
public:
	CDraw();           // protected constructor used by dynamic creation
	//{{AFX_DATA(CDraw)
	enum { IDD = IDD_FORMVIEW_Draw };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

// Attributes
public:

// Operations
public:
	CDaoDatabase*   m_pDatabase;
	CDaoRecordset*  m_pRecordset;

	CString			m_DBFileName;
	CString			m_strTableName;

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDraw)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	virtual void OnDraw(CDC* pDC);
	//}}AFX_VIRTUAL

// Implementation
protected:
	virtual ~CDraw();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

	// Generated message map functions
	//{{AFX_MSG(CDraw)
	afx_msg void OnButton1();
	afx_msg void OnButton2();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DRAW_H__7C7F0055_491F_403E_8441_213ECB5127CE__INCLUDED_)
