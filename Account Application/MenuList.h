#if !defined(AFX_MENULIST_H__9C52CDB6_0F9D_4CD0_85CE_1A2609BE14E3__INCLUDED_)
#define AFX_MENULIST_H__9C52CDB6_0F9D_4CD0_85CE_1A2609BE14E3__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// MenuList.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CMenuList form view

#ifndef __AFXEXT_H__
#include <afxext.h>
#endif

class CMenuList : public CFormView
{
protected:
	CMenuList();           // protected constructor used by dynamic creation
	DECLARE_DYNCREATE(CMenuList)

// Form Data
public:
	//{{AFX_DATA(CMenuList)
	enum { IDD = IDD_FORMVIEW_Menu };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMenuList)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	virtual ~CMenuList();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

	// Generated message map functions
	//{{AFX_MSG(CMenuList)
		// NOTE - the ClassWizard will add and remove member functions here.
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_MENULIST_H__9C52CDB6_0F9D_4CD0_85CE_1A2609BE14E3__INCLUDED_)
