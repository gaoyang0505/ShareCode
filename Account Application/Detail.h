#if !defined(AFX_DETAIL_H__2009E7A8_E6AD_4DBA_9EF0_9393B611F70D__INCLUDED_)
#define AFX_DETAIL_H__2009E7A8_E6AD_4DBA_9EF0_9393B611F70D__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Detail.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CDetail form view

#ifndef __AFXEXT_H__
#include <afxext.h>
#endif

class CDetail : public CFormView
{
protected:
	DECLARE_DYNCREATE(CDetail)

// Form Data
public:
	//{{AFX_DATA(CDetail)
	enum { IDD = IDD_FORMVIEW_Detail };
	CDateTimeCtrl	m_timeStartD;
	CDateTimeCtrl	m_timeEndD;
	CListCtrl	m_ctrList3;
	//}}AFX_DATA

// Attributes
public:

	bool UpdateView(); //在数据库更新时，更新界面
	bool DeleteItem(); //删除一个数据
	CString strVARIANT(const COleVariant& var);

	CDaoDatabase*   m_pDatabase;
	CDaoRecordset*  m_pRecordset;

	CString			m_DBFileName;
	CString			m_strTableName;

	int check1;
	int check2;
// Operations
public:
	CDetail();           // protected constructor used by dynamic creation
// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDetail)
	public:
	virtual void OnInitialUpdate();
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	virtual ~CDetail();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

	// Generated message map functions
	//{{AFX_MSG(CDetail)
	afx_msg void OnButton2();
	afx_msg void OnButton1();
	afx_msg void OnButton3();
	afx_msg HBRUSH OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor);
	afx_msg void OnCheck1();
	afx_msg void OnCheck2();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DETAIL_H__2009E7A8_E6AD_4DBA_9EF0_9393B611F70D__INCLUDED_)
