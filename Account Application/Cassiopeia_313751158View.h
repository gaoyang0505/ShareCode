// Cassiopeia_313751158View.h : interface of the CCassiopeia_313751158View class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CASSIOPEIA_313751158VIEW_H__02FAE7EC_E360_4D6F_88A3_541D5CC12929__INCLUDED_)
#define AFX_CASSIOPEIA_313751158VIEW_H__02FAE7EC_E360_4D6F_88A3_541D5CC12929__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CCassiopeia_313751158View : public CFormView
{
protected: // create from serialization only

	DECLARE_DYNCREATE(CCassiopeia_313751158View)

	CString time;
	int radio1;
	int radio2;

public:
	//{{AFX_DATA(CCassiopeia_313751158View)
	enum { IDD = IDD_CASSIOPEIA_313751158_FORM };
	CDateTimeCtrl	m_timeEnd;
	CDateTimeCtrl	m_timeStart;
	CDateTimeCtrl	m_timeTime;
	CComboBox	m_ctrCombo1;
	CListCtrl	m_ctrList1;
	CString	m_strStatic1;
	CString	m_strEdit2;
	CString	m_floEdit1;
	//}}AFX_DATA
	


// Attributes
public:
	CCassiopeia_313751158Doc* GetDocument();

	bool UpdateView(); //在数据库更新时，更新界面
	bool DeleteItem(); //删除一个数据
	CString strVARIANT(const COleVariant& var);


	CDaoDatabase*   m_pDatabase;
	CDaoRecordset*  m_pRecordset;
	CString			m_DBFileName;
	CString			m_strTableName;
// Operations
public:
	CCassiopeia_313751158View();
// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCassiopeia_313751158View)
	public:
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	virtual BOOL PreTranslateMessage(MSG* pMsg);
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	virtual void OnInitialUpdate(); // called first time after construct
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnPrint(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CCassiopeia_313751158View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CCassiopeia_313751158View)
	afx_msg void OnButton1();
	afx_msg void OnButton2();
	afx_msg void OnButton3();
	afx_msg void OnButton4();
	afx_msg void OnRadio1();
	afx_msg void OnRadio2();
	afx_msg void OnRadio3();
	afx_msg void OnRadio4();
	afx_msg void OnRadio5();
	afx_msg void OnButton5();
	afx_msg void OnButton6();
	afx_msg void OnClickList2(NMHDR* pNMHDR, LRESULT* pResult);
	afx_msg void OnKillFocus(CWnd* pNewWnd);
	afx_msg void OnFileSave();
	afx_msg HBRUSH OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in Cassiopeia_313751158View.cpp
inline CCassiopeia_313751158Doc* CCassiopeia_313751158View::GetDocument()
   { return (CCassiopeia_313751158Doc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CASSIOPEIA_313751158VIEW_H__02FAE7EC_E360_4D6F_88A3_541D5CC12929__INCLUDED_)
