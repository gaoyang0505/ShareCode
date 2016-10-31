// MenuList.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "MenuList.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMenuList

IMPLEMENT_DYNCREATE(CMenuList, CFormView)

CMenuList::CMenuList()
	: CFormView(CMenuList::IDD)
{
	//{{AFX_DATA_INIT(CMenuList)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CMenuList::~CMenuList()
{
}

void CMenuList::DoDataExchange(CDataExchange* pDX)
{
	CFormView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CMenuList)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CMenuList, CFormView)
	//{{AFX_MSG_MAP(CMenuList)
		// NOTE - the ClassWizard will add and remove mapping macros here.
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMenuList diagnostics

#ifdef _DEBUG
void CMenuList::AssertValid() const
{
	CFormView::AssertValid();
}

void CMenuList::Dump(CDumpContext& dc) const
{
	CFormView::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMenuList message handlers
