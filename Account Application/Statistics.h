#if !defined(AFX_STATISTICS_H__0665F9FF_5259_44B8_8EFC_DD9483C4F041__INCLUDED_)
#define AFX_STATISTICS_H__0665F9FF_5259_44B8_8EFC_DD9483C4F041__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// Statistics.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CStatistics form view

#ifndef __AFXEXT_H__
#include <afxext.h>
#endif

class CStatistics : public CFormView
{
protected:

	DECLARE_DYNCREATE(CStatistics)

// Form Data
public:
	//{{AFX_DATA(CStatistics)
	enum { IDD = IDD_FORMVIEW_Statistics };
	CListCtrl	m_ctrlList2;
	CDateTimeCtrl	m_timeEndN;
	CDateTimeCtrl	m_timeStartN;
	CString	m_strResult;
	CString	m_strHave;
	CString	m_strOut;
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

// Operations
public:
	CStatistics();           // protected constructor used by dynamic creation

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CStatistics)
	public:
	virtual void OnInitialUpdate();
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	virtual ~CStatistics();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

	// Generated message map functions
	//{{AFX_MSG(CStatistics)
	afx_msg void OnButton1();
	afx_msg void OnButton2();
	afx_msg void OnButton3();
	afx_msg HBRUSH OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_STATISTICS_H__0665F9FF_5259_44B8_8EFC_DD9483C4F041__INCLUDED_)
