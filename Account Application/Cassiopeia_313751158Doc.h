// Cassiopeia_313751158Doc.h : interface of the CCassiopeia_313751158Doc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CASSIOPEIA_313751158DOC_H__A8284AAA_035A_4997_9925_E54BB4019C4B__INCLUDED_)
#define AFX_CASSIOPEIA_313751158DOC_H__A8284AAA_035A_4997_9925_E54BB4019C4B__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
#include <vector>
using namespace std;

class CCassiopeia_313751158Doc : public CDocument
{
protected: // create from serialization only
	CCassiopeia_313751158Doc();
	DECLARE_DYNCREATE(CCassiopeia_313751158Doc)

// Attributes
public:
	vector<CString> m_vctContent;

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CCassiopeia_313751158Doc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CCassiopeia_313751158Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CCassiopeia_313751158Doc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CASSIOPEIA_313751158DOC_H__A8284AAA_035A_4997_9925_E54BB4019C4B__INCLUDED_)
